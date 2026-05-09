package queuesystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Client implements Comparable<Client> {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String status;
        private int priorityLevel;

        @Override public int compareTo(Client other) {
                return Integer.compare(other.priorityLevel, this.priorityLevel);
        }



}
