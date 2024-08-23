package googledrive.domain;

import googledrive.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class FileUploaded extends AbstractEvent {

    private Long id;
    private Long userId;
    private File file;
    private Date uploadDt;
    private Long size;
    private String fileName;
}
