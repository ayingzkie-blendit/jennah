package co.ulimit.jennah.domain

import io.leangen.graphql.annotations.GraphQLQuery
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.NotFound
import org.hibernate.annotations.NotFoundAction
import org.hibernate.annotations.Type

import javax.persistence.*

@Entity
@Table(name = "items", schema = "public")
class Item extends AbstractAuditingEntity {
	@GraphQLQuery
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "id", columnDefinition = "uuid")
	@Type(type = "pg-uuid")
	UUID id

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category", referencedColumnName = "id")
	Category category

	@GraphQLQuery
	@Column(name = "sku_barcode", columnDefinition = "varchar")
	String skuBarcode

	@GraphQLQuery
	@Column(name = "stock_code", columnDefinition = "varchar")
	String stockCode

	@GraphQLQuery
	@Column(name = "brand", columnDefinition = "varchar")
	String brand

	@GraphQLQuery
	@Column(name = "item_name", columnDefinition = "varchar")
	String itemName

	@GraphQLQuery
	@Column(name = "unit_cost", columnDefinition = "numeric")
	BigDecimal unitCost

	@GraphQLQuery
	@Column(name = "initial_markup", columnDefinition = "numeric")
	BigDecimal initialMarkup

	@GraphQLQuery
	@Column(name = "usage_unit", columnDefinition = "varchar")
	String usageUnit

	@GraphQLQuery
	@Column(name = "purchase_unit", columnDefinition = "varchar")
	String purchaseUnit

	@GraphQLQuery
	@Column(name = "conversion_qty", columnDefinition = "int")
	Integer conversionQty
}
