package br.com.srm.pagamento_service.adapters.in;

import br.com.srm.pagamento_service.port.in.RealizarPagamentoUseCasePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaPagamentoListener {
    @Autowired
    private RealizarPagamentoUseCasePort realizarPagamentoUseCasePort;

    @KafkaListener(topics = "topico-pagamento", groupId = "emprestimo-consumer-group")
    public void realizarPagamento(String idEmprestimo) {
        try {
            Long emprestimoId = Long.parseLong(idEmprestimo);
            realizarPagamentoUseCasePort.realizarPagamento(emprestimoId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
