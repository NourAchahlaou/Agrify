/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrify.services;
import java.util.List;

/**
 *
 * @author tbagh
 */
public interface IServiceUser <T>{
      public void ajouter(T t);
    public void modifier(T t);
    public void supprimer(int id);
    public T getOne(int id);  // Changed to getOne by user_id
    public List<T> getAll();
}