package root.awsImage.fileDownLoad;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;

@Service
public class FileStore {

    private final AmazonS3 s3;

    public FileStore(final AmazonS3 s3) {
        this.s3 = s3;
    }

    /**
     * To download image stream as a byte with the given path and key.
     * @param path
     * @param key
     * @return the rest of the given input stream as a byte array.
     */
    public byte[] download(final String path, final String key) {
        try {
            // take the path and the actual key of image
            final S3Object object = s3.getObject(path, key);
            return IOUtils.toByteArray(object.getObjectContent());
            
        } catch (final AmazonServiceException | IOException e) {
            throw new IllegalStateException("Failed to download file to s3", e);
        }
    }

}
