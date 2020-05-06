package jpamodel;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.online.entities.Product;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, String> brandName;
	public static volatile SingularAttribute<Product, Date> purchaseDate;
	public static volatile SingularAttribute<Product, String> cost;
	public static volatile SingularAttribute<Product, Integer> productId;
	public static volatile SingularAttribute<Product, String> mobileModel;

	public static final String BRAND_NAME = "brandName";
	public static final String PURCHASE_DATE = "purchaseDate";
	public static final String COST = "cost";
	public static final String PRODUCT_ID = "productId";
	public static final String MOBILE_MODEL = "mobileModel";

}

