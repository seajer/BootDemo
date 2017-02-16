package entity;

public class Data implements DomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	
	public Data(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
