
@Id - указывает на Primary Key. Может быть применена к типам-примитивам, оберткам над ними, а также java.util.Date, java.sql.Date,
java.math.BigDecimal, java.math.BigInteger

@GeneratedValue - нужна для генерации первичных ключей (с определенными стратегиями)
strategy - стратегия генерации (GenerationType)
SEQUENCE -  использование database sequence
TABLE - использует таблицу БД, соответствующую энтити, чтобы удостовериться в уникальности
IDENTITY - database identity column
AUTO - jpa провайдер сам должен выбрать в соответствии с типом БД


generator - имя кастомного генератора is

@SequenceGenerator - аннотация для собственного генератора
@GenericGenerator - describing any kind of Hibernate generator in a generic (de-typed) manner
@TableGenerator - аннотация для собственного генератора

@Embeddable - аннотация для класса, который планируется использовать в качестве составного первичного ключа
@EmbeddedId - для создания композитного ключа на основе класса, помеченного @Embeddable
@IdClass - почти как @EmbeddedId, только все id определяются в классе ентити (вместо экземпляра класса-ид)

@AttributeOverride - перекрытие имен полей
@AttributeOverrides - лист аннотаций @AttributeOverride


@OneToOne
targetEntity - class that is the target of association
cascadeType - strategy of cascading operation to the associated entity
 (ALL, PERSIST, MERGE, REMOVE, REFRESH, DETACH)
fetch - fetching strategy (LAZY, EAGER)
optional - default true - whether non-null relation should always exists
mappedBy - field that owns relation
orphanRemoval - cascade remove operation (default false)

@OneToMany
targetEntity
cascade
fetch
mappedBy
orphanRemoval

@ManyToOne
targetEntity
cascade
fetch
optional

@JoinColumn - Specifies a column for joining an entity association
or element collection (foreign key column)

@ManyToMany
targetEntity
cascade
fetch
mappedBy

@Inheritance
strategy:
SINGLE_TABLE (default) - single table for all entities
TABLE_PER_CLASS - table on every entity class
JOINED - specific fields in separate tables, commons - in shared table

@Fetch
fetchMode: 
SELECT - for lazy load (causes n+1 problem: one query for element and n for inner collection elements.
Can be fixed with @BatchSize(size=10))
JOIN - eager load
SUBSELECT - for lazy load, inner select syntax

@MapsId -?

@MapKeyColumn - ?