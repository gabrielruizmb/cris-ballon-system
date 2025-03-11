package system;

import java.time.LocalDateTime;

public interface CreationDateInterface {
    // Assinaturas de métodos a serem sobrescritos
    // pelas classes que implementam esta interface.
    public LocalDateTime getCreationDate();
    public void setCreationDate(LocalDateTime creationDate);
}
