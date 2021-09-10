package br.com.zupacademy.transacao.kafka.consumers;

import br.com.zupacademy.transacao.models.CartaoModel;

import javax.validation.constraints.NotNull;
import java.util.StringJoiner;

public class CartaoConsumer {

    private String id;
    private String email;

    @Deprecated
    public CartaoConsumer() {
    }

    public CartaoConsumer(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public @NotNull CartaoModel toModel() {
        return new CartaoModel(this.id, this.email);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CartaoConsumer.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("email='" + email + "'")
                .toString();
    }
}