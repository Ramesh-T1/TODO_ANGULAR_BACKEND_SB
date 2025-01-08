package TODO.SB_Angular.entities;

import java.util.Date;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class TODO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	@NotNull
	@Size(min = 3, max = 50)
	public String usersnmae;
	@NotNull
	@Size(min = 3, max = 50)
	public String description;
	@NotNull
	public boolean isDone;
	public Date targetDate;

	public TODO() {

	}

	public TODO(long id, String usersnmae, String description, boolean isDone, Date targetDate) {
		this.id = id;
		this.usersnmae = usersnmae;
		this.description = description;
		this.isDone = isDone;
		this.targetDate = targetDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsersnmae() {
		return usersnmae;
	}

	public void setUsersnmae(String usersnmae) {
		this.usersnmae = usersnmae;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TODO other = (TODO) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "TODO [id=" + id + ", usersnmae=" + usersnmae + ", description=" + description + ", isDone=" + isDone
				+ ", targetDate=" + targetDate + "]";
	}

}
