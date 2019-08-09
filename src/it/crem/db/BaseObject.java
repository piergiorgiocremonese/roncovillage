package it.crem.db;


import java.lang.reflect.Method;

public class BaseObject implements Comparable{
	
	protected int oid = 0;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}
	
	public Integer getIntValue(String object, String meth){
		Object o = null;
		Class noparams[] = {};
		Integer l = null;
		try{
			//String meth = "get"+field;
			Class cls = this.getClass();
			//Class cls = Class.forName(object);
			Object obj = cls.newInstance();
			Method method = cls.getDeclaredMethod(meth, noparams);
			o=method.invoke(this, null);
			l = (Integer)o;
		}
		catch (Exception E){
			System.out.println(E.toString());
		}
		
		
		return l;
		
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		BaseObject bo = (BaseObject)o;
		
		int cmp = 0;
		
		if (oid == bo.getOid())
			cmp = 0;
		else if (oid>bo.getOid())
				cmp=1;
			else
				cmp=2;
		return cmp;
	}
	

}
