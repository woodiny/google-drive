package googledrive.infra;

import googledrive.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "fileStatuses",
    path = "fileStatuses"
)
public interface FileStatusRepository
    extends PagingAndSortingRepository<FileStatus, Long> {
    List<FileStatus> findByFileId(Long fileId);
}
