package gsonstream;

public class Person {

	public Person(String name, String sirname, Long social_no, Long creadit_card_no) {
		this.name = name;
		this.sirname = sirname;
		this.social_no = social_no;
		this.creadit_card_no = creadit_card_no;
	}

	private String name;
	private String sirname;
	private Long social_no;
	private Long creadit_card_no;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSirname() {
		return sirname;
	}

	public void setSirname(String sirname) {
		this.sirname = sirname;
	}

	public Long getSocial_no() {
		return social_no;
	}

	public void setSocial_no(Long social_no) {
		this.social_no = social_no;
	}

	public Long getCreadit_card_no() {
		return creadit_card_no;
	}

	public void Long(Long creadit_card_no) {
		this.creadit_card_no = creadit_card_no;
	}

	@Override
	public String toString() {
		String NEW_LINE = System.getProperty("line.separator");

		StringBuilder sb = new StringBuilder("Person {");
		sb.append(NEW_LINE);
		sb.append("name: ");
		sb.append(name);
		sb.append(NEW_LINE);

		sb.append("sirname: ");
		sb.append(sirname);
		sb.append(NEW_LINE);

		sb.append("social_no: ");
		sb.append(social_no);
		sb.append(NEW_LINE);

		sb.append("creadit_card_no: ");
		sb.append(creadit_card_no);
		sb.append(NEW_LINE);

		sb.append("}");
		sb.append(NEW_LINE);

		return sb.toString();
	}
}
