package hiber.dao;

import hiber.model.User;
import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user, Car car) {
      user.setUserCar(car);
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }



   @Override
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   public User owner(String model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User user where user.userCar.model = :m and user.userCar.series = :s");
      query.setParameter("m", model);
      query.setParameter("s", series);
      return query.getSingleResult();
   }
}
