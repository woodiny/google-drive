package googledrive.domain;

import googledrive.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "videoProcessings",
    path = "videoProcessings"
)
public interface VideoProcessingRepository
    extends PagingAndSortingRepository<VideoProcessing, Long> {}
