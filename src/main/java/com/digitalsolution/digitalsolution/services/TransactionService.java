package com.digitalsolution.digitalsolution.services;

import com.digitalsolution.digitalsolution.entityes.Transaction;
import com.digitalsolution.digitalsolution.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * El sistema permite consultar todas las transacciones
     */
    public List<Transaction> obtenerTransaction() {

        return  this.transactionRepository.findAll();
    }


    /**
     * El sistema permite crear una transacción
     */
    public boolean crearTransaction(Transaction transaction) {

if (!this.transactionRepository.findById(transaction.getIdm()).isPresent()){
    this.transactionRepository.save(transaction);
    return true;
}
        return false;
    }

    /**
     * El sistema permite consultar una sola transacción
     *
     *
     */
    public Optional<Transaction> obtenerTransaction(Long idm) {



        return  this.transactionRepository.findById(idm);

    }

    /**
     * El sistema permite editar una transacción
     *
     */
    public boolean actualizarTransaction(Transaction transaction, Long idm) {
        Optional<Transaction> transact = this.transactionRepository.findById(idm);

        if (transact.isPresent()){
            transact.get().setConcept(transaction.getConcept());
            transact.get().setAmount(transaction.getAmount());
            transact.get().setTypeAmount(transaction.getTypeAmount());
            transact.get().setUsuario(transaction.getUsuario());
            transact.get().setEnterprise(transaction.getEnterprise());
            transact.get().setCreatedat(transaction.getCreatedat());
            transact.get().setUpdatedat(transaction.getUpdatedat());

            this.transactionRepository.save(transact.get());

            return true;
        }

        return false;
    }

    /**
     * El sistema permite eliminar una transacción
     *
     */
    public boolean eliminarTransaction(Long idm) {
        if (this.transactionRepository.findById(idm).isPresent()){
            this.transactionRepository.deleteById(idm);
            return true;
        }

        return false;
    }

    /**
     * El sistema permite consultar una sola transacción por columna determinada
     */
    public List<Transaction> obtenerTransactionEnterprise(Long enterprise) {

        return this.transactionRepository.findByIdTransaction(enterprise);
    }
}
