package edu.usmp.demodashboard.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.usmp.demodashboard.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,String>{
    
    @Query("SELECT p.tipoTarjeta as tipoTarjeta,SUM(p.montoTotal) as montoTotal FROM Payment p GROUP BY p.tipoTarjeta")
    List<Map<String, Object>> queryByTipoTarjeta();


}
