package by.epam.tc.entity;

import java.io.Serializable;

public class Application implements Serializable {

	private static final long serialVersionUID = -69858447082765604L;
	
	private int id;
	private String name;
	private String email;
	private String privelege;
	private String school;
	private String specialty;
	
	public Application() {
		// TODO Auto-generated constructor stub
	}

	public Application(int id, String name, String email, String privelege, String school, String specialty) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.privelege = privelege;
		this.school = school;
		this.specialty = specialty;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getPrivelege() {
		return privelege;
	}

	public final void setPrivelege(String privelege) {
		this.privelege = privelege;
	}

	public final String getSchool() {
		return school;
	}

	public final void setSchool(String school) {
		this.school = school;
	}

	public final String getSpecialty() {
		return specialty;
	}

	public final void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", name=" + name + ", email=" + email + ", privelege=" + privelege
				+ ", school=" + school + ", specialty=" + specialty + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((privelege == null) ? 0 : privelege.hashCode());
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		result = prime * result + ((specialty == null) ? 0 : specialty.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Application other = (Application) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (privelege == null) {
			if (other.privelege != null) {
				return false;
			}
		} else if (!privelege.equals(other.privelege)) {
			return false;
		}
		if (school == null) {
			if (other.school != null) {
				return false;
			}
		} else if (!school.equals(other.school)) {
			return false;
		}
		if (specialty == null) {
			if (other.specialty != null) {
				return false;
			}
		} else if (!specialty.equals(other.specialty)) {
			return false;
		}
		return true;
	}
	
	
	
	
	

}
