package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FileUploaded extends AbstractEvent {

    private Long id;
    private Long userId;
    private Object file;
    private Date uploadDt;
    private Long size;
    private String fileName;
}
