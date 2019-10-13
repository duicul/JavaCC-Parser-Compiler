package domain;

public abstract class Domain {
protected String name;
protected Domain upper=null;
public abstract boolean test(String name);
public boolean equalname(String name) {
	return this.name==name;
}
public abstract void add(Domain d) throws DomainException;
}
