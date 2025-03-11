package system;

import java.time.LocalDateTime;

// Implementamos esta inferface para dizer que vamos usar as assinaturas
// de métodos nela escritas, definindo comportamentos para nossa classe.
public class CreationDate implements CreationDateInterface {
    private LocalDateTime creationDate;

    /*  O @Override diz que o método abaixo está usando a mesma assinatura
        do método com o mesmo nome na interface. Ou seja, tem o mesmo:
        1) Modificador de acesso(private, public, protected),
        2) Tipo de retorno(String, int, LocalDateTime, void),
        3) Nome e parâmetros recebidos. ex: setName(String name).
    */

    @Override
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
