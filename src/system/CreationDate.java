package system;

import java.time.LocalDateTime;

// Implementamos esta inferface para dizer que vamos usar as assinaturas
// de métodos nela escritas, agora somos obrigados a definir um corpo para
// todos estes métodos.
public class CreationDate implements CreationDateInterface {
    private LocalDateTime creationDate;

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
