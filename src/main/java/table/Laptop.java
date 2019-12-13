package table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Laptop {
	@Id
	int laptop_id;
	String laptop_name;

	public Laptop() {
		super();
	}

	public Laptop(int laptop_id, String laptop_name) {
		super();
		this.laptop_id = laptop_id;
		this.laptop_name = laptop_name;
	}


	public int getLaptop_id() {
		return laptop_id;
	}

	public void setLaptop_id(int laptop_id) {
		this.laptop_id = laptop_id;
	}

	public String getLaptop_name() {
		return laptop_name;
	}

	public void setLaptop_name(String laptop_name) {
		this.laptop_name = laptop_name;
	}

	@Override
	public String toString() {
		return "Laptop [laptop_id=" + laptop_id + ", laptop_name=" + laptop_name + "]";
	}

}
