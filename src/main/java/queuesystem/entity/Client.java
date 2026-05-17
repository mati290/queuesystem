package queuesystem.entity;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
        @NotBlank
        private String name;
        @Email
        @NotBlank  //walidacja, że email nie może być pusty
        private String email;
        @NotBlank
        private String status;
        @Min(0)
        private int priorityLevel;

        @Override public int compareTo(Client other) {
                return Integer.compare(other.priorityLevel, this.priorityLevel);
        }
public String getClientType(){
        return "REGULAR";
        }
}
