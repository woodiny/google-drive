package googledrive.infra;

import googledrive.config.kafka.KafkaProcessor;
import googledrive.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class FileStatusViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private FileStatusRepository fileStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileUploaded_then_CREATE_1(
        @Payload FileUploaded fileUploaded
    ) {
        try {
            if (!fileUploaded.validate()) return;

            // view 객체 생성
            FileStatus fileStatus = new FileStatus();
            // view 객체에 이벤트의 Value 를 set 함
            fileStatus.setSize(fileUploaded.getSize());
            fileStatus.setFileName(fileUploaded.getFileName());
            // view 레파지 토리에 save
            fileStatusRepository.save(fileStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenVideoProcessed_then_UPDATE_1(
        @Payload VideoProcessed videoProcessed
    ) {
        try {
            if (!videoProcessed.validate()) return;
            // view 객체 조회

            List<FileStatus> fileStatusList = fileStatusRepository.findByFileId(
                Long.valueOf(videoProcessed.getFileId())
            );
            for (FileStatus fileStatus : fileStatusList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                fileStatus.setVideoUrl(videoProcessed.getVideoUrl());
                // view 레파지 토리에 save
                fileStatusRepository.save(fileStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
