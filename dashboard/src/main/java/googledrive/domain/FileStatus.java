package googledrive.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "FileStatus_table")
@Data
public class FileStatus {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long size;
    private String fileName;
    private Boolean isIndexed;
    private Boolean isUpload;
    private String videoUrl;
    private Long fileId;
}
