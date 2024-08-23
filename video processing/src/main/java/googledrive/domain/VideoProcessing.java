package googledrive.domain;

import googledrive.VideoProcessingApplication;
import googledrive.domain.VideoProcessed;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "VideoProcessing_table")
@Data
//<<< DDD / Aggregate Root
public class VideoProcessing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileId;

    private String videoUrl;

    private Long uploaderId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        VideoProcessed videoProcessed = new VideoProcessed(this);
        videoProcessed.publishAfterCommit();
    }

    public static VideoProcessingRepository repository() {
        VideoProcessingRepository videoProcessingRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoProcessingRepository.class
        );
        return videoProcessingRepository;
    }

    //<<< Clean Arch / Port Method
    public static void processVideoStreaming(FileUploaded fileUploaded) {
        //implement business logic here:

        /** Example 1:  new item 
        VideoProcessing videoProcessing = new VideoProcessing();
        repository().save(videoProcessing);

        VideoProcessed videoProcessed = new VideoProcessed(videoProcessing);
        videoProcessed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(videoProcessing->{
            
            videoProcessing // do something
            repository().save(videoProcessing);

            VideoProcessed videoProcessed = new VideoProcessed(videoProcessing);
            videoProcessed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
