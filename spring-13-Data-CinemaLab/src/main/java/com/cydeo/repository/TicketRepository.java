package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countByUserAccount(User user);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findByUserAccount_Email(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countByMovieCinema_Movie_Name(String name);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findByDateTimeBetween(LocalDateTime dateTime, LocalDateTime dateTime2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t WHERE t.userAccount.id = ?1")
    List<Ticket> retrieveAllTicketsForSpecificUser(@Param("id") Long id);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> retrieveTicketsBetweenDate(@Param("startDate")LocalDate startDate, @Param("endDate") LocalDate endDate);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT COUNT(*) FROM ticket WHERE user_account_id = ?1", nativeQuery = true)
    Integer countAllTicketsUserBuy(@Param("id") Long id);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT COUNT(*) FROM ticket WHERE date_time BETWEEN ?1 AND ?2", nativeQuery = true)
    Integer countAllTicketsForSpecificDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT DISTINCT * FROM ticket t JOIN movie_cinema mc ON t.movie_cinema_id = mc.id " +
            "JOIN movie m ON m.id = mc.movie_id WHERE m.name = ?1", nativeQuery = true)
    List<Ticket> distinctAllTicketsByMovieName(@Param("name") String name);

    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id " +
            "WHERE ua.email = ?1", nativeQuery = true)
    List<Ticket> retrieveTicketsByUserEmail(@Param("email") String email);

    //Write a native query that returns all tickets
    @Query(value = "SELECT * FROM ticket", nativeQuery = true)
    List<Ticket> allTickets();

    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id " +
            "JOIN movie_cinema mc ON t.movie_cinema_id = mc.id " +
            "JOIN movie m ON mc.movie_id = m.id " +
            "JOIN account_details ad ON ua.account_detail_id = ad.id " +
            "WHERE ua.username ILIKE concat('%', ?1, '%')" +
            "OR ad.name ILIKE concat('%', ?1, '%')" +
            "OR m.name ILIKE concat('%', ?1, '%')"
            , nativeQuery = true)
    List<Ticket> retrieveTicketsBySearchCriteria(@Param("pattern") String pattern);

}
