package com.prueba.nexos.prueba.infrastructure.adapter.postgres.RepositoryAdapter;

import com.prueba.nexos.prueba.domain.domain.card.gateways.CardRepository;
import com.prueba.nexos.prueba.domain.domain.status.request.Estado;
import com.prueba.nexos.prueba.domain.model.request.Card;
import com.prueba.nexos.prueba.infrastructure.adapter.postgres.entity.CardEntitity;
import com.prueba.nexos.prueba.infrastructure.adapter.postgres.entity.EstadoEntity;
import com.prueba.nexos.prueba.infrastructure.adapter.postgres.repository.CardEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class CardRepositoryAdapterTest {

    @MockBean
    private CardEntityRepository cardEntityRepository;


    private CardRepositoryAdapter cardRepositoryAdapter;

    @BeforeEach
    void setup(){

    }

    @Test
    void generateCard() {
        EstadoEntity estadoMock=EstadoEntity.builder().estadoId(1L).nombreEstado("APROBADA").build();
        CardEntitity cardMockRequest= CardEntitity
                .builder()
                .cardId("1234567674555246")
                .estadoId(estadoMock)
                .balance(0.0)
                .nombreTitular("jonathan romero")
                .fechaCreacion(LocalDate.parse("2024-02-25"))
                .fechaVencimiento(LocalDate.parse("2024-02-25"))
                .build();
        CardEntitity cardMockRequest2= CardEntitity
                .builder()
                .cardId("1234567674555246")
                .estadoId(estadoMock)
                .balance(0.0)
                .nombreTitular("jonathan romero")
                .fechaCreacion(LocalDate.parse("2024-02-25"))
                .fechaVencimiento(LocalDate.parse("2024-02-25"))
                .build();
        Card cardMock = Card.builder()
                .cardId("1234567674555246")
                .balance(0.0)
                .nombreTitular("Jonathan")
                .fechaVencimiento(LocalDate.now())
                .fechaCreacion(LocalDate.now())
                .estado(Estado.builder().estadoId(1L).nombreEstado("APROBADA").build())
                .build();

        when(cardEntityRepository.save(cardMockRequest)).thenReturn(cardMockRequest2);

        Card cardObtenido= cardRepositoryAdapter.generateCard(cardMock);

        verify(cardEntityRepository,times(1)).save(cardMockRequest);

        assertEquals(cardMock.getCardId(),cardObtenido.getCardId());

    }

    @Test
    void findByCardId() {

        EstadoEntity estadoMock=EstadoEntity.builder().estadoId(1L).nombreEstado("APROBADA").build();

        CardEntitity cardMock= CardEntitity
                .builder()
                .cardId("1234564537637302")
                .estadoId(estadoMock)
                .balance(0.0)
                .nombreTitular("jonathan romero")
                .fechaCreacion(LocalDate.parse("2024-02-25"))
                .fechaVencimiento(LocalDate.parse("2024-02-25"))
                .build();


        String cardId= "1234564537637302";
        when(cardEntityRepository.findById(cardId)).thenReturn(Optional.of(cardMock));

        Card cardObtenido= cardRepositoryAdapter.findByCardId(cardId);

        verify(cardEntityRepository,times(1)).findById(cardId);

        assertEquals(cardId,cardObtenido.getCardId());

    }



    @Test
    void activeCardOrBlockOrBalance() {
    }
}