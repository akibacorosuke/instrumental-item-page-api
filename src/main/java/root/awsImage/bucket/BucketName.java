package root.awsImage.bucket;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BucketName {

    PROFILE_IMAGE("image-upload-sample");

    private final String bucketName;

}
