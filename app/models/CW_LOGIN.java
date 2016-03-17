package models;

import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
public class CW_LOGIN extends Model {

    @Id
    public long seq;

    public String username;
    public String password;
}
