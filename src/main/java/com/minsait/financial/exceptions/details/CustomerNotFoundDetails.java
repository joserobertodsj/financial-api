package com.minsait.financial.exceptions.details;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CustomerNotFoundDetails {
    private String titulo;
    private int status;
    private LocalDateTime timestamp;
    private String mensagem;

    private CustomerNotFoundDetails(){

    }

    public static final class CustomerNotFoundDetailsBuilder {
        private String titulo;
        private int status;
        private LocalDateTime timestamp;
        private String mensagem;

        private CustomerNotFoundDetailsBuilder() {
        }

        public static CustomerNotFoundDetailsBuilder newBuild() {
            return new CustomerNotFoundDetailsBuilder();
        }

        public CustomerNotFoundDetailsBuilder withTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public CustomerNotFoundDetailsBuilder withStatus(int status) {
            this.status = status;
            return this;
        }

        public CustomerNotFoundDetailsBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public CustomerNotFoundDetailsBuilder withMensagem(String mensagem) {
            this.mensagem = mensagem;
            return this;
        }

        public CustomerNotFoundDetails build() {
            CustomerNotFoundDetails customerNotFoundDetails = new CustomerNotFoundDetails();
            customerNotFoundDetails.status = this.status;
            customerNotFoundDetails.timestamp = this.timestamp;
            customerNotFoundDetails.titulo = this.titulo;
            customerNotFoundDetails.mensagem = this.mensagem;
            return customerNotFoundDetails;
        }
    }
}
