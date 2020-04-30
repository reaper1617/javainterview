Spring Annotations


@SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan

@Controller = аннотация для отдачи представления, обычно используется с @RequestMapping
@RestController = @Controller + @ResponseBody
@RequestBody - указывает спрингу, что параметр метода должен быть привязан к телу запроса(http request)
@ResponseBody - указывает спрингу, что возвращаемое значение должно быть привязано к телу ответа (http response)
@RequestMapping - указывает URL маппинг и тип метода (get, post, put ..)

@Transactional(JAVA)- 
value: TxType: REQUIRED(default) - если метод вызван вне транзацкии, то должна быть открыта новая Jakarta Transactions transaction
REQUIRES_NEW - всегда открывается новая транзакция
MANDATORY - обязательна транзакция, если нет - TransactionalException
SUPPORTS - можно и с транзакцией, и без
NOT_SUPPORTED - метод должен быть обработан вне контекста транзакции, если она есть
NEVER - транзакции не поддерживаются , при вызове из транзакции - TransactionalException

@Transactional(SPRING)- 

value - alias for transactionManager
transactionManager - transactionManager
propagation - Propagation.REQUIRED - поддерживает текущую транзакцию, если ее нет, создается новая
SUPPORTS - может выполняться в текущей транзакции, но если ее нет, новая не создается
MANDATORY - должен запускаться в текущей транзакции, если ее нет - выкидывает исключение
REQUIRES_NEW - создает новую транзакцию в любом случае
NOT_SUPPORTED - выполняется нетранзакционно, если текущая транзакция есть - приостанавливает ее, потом возобновляет
NEVER - выполняется только вне транзакции, если она есть, выбрасывается исключение
NESTED - как required

isolation: DEFAULT - specific to database
READ_UNCOMMITED - позволяет читать данные из одной транзакции, измененные и незакоммиченные другой транзакцией
READ_COMMITED - не позволяются "dirty read", при этом non-repeatable reads (row is retrieved twice 
and the values within the row differ between reads.) и phantom reads (in the course of a transaction, two identical queries are executed, 
and the collection of rows returned by the second query is different from the first.) доступны
REPEATABLE_READ - защищена от dirty and unrepeatable reads (phantom reads разрешены)
SERIALIZABLE - максимальная степень изоляции

timeout - время жизни транзакции

readOnly - оптимизация в рантайме (boolean)

rollbackFor - массив классов исключений, при которых будет откат транзакции
noRollbackFor - массив классов исключений, при которых отката транзакции не будет
rollbackForClassName и noRollbackForClassName - то же самое, но массивы имен классов - строки

@Scope
"singleton" - single instance (default)
"prototype" - different instance from container for every request
"request" (only for web) - new for every Http request
"session" (only for web) - new for every Http session
"application" (only for web)  - new for every servlet context
"websocket" (only for web) - new for every websocket session

@ComponentScan - specify packages to be scanned for beans

@Component
@Service - just an alias for more determined use
@Repository = @Component + additional PersistenceExceptionTranslationPostProcessor

@EnableScheduling - enables support for scheduling tasks
@Scheduled - used with void return type; no parameters in method
cron - cron-like expression
fixedDelay - millis delay between last end and new start
fixedDelayString - the same in string 
fixedRate - millis delay between starts of methods
fixedRateString -the same in string
initialDelay - delay before the first execution
initialDelayString - the same in string
zone - time zone for cron (string)

@Configuration - means that classes can be bootstrapped for bean configuring

@Qualifier - choose bean name for autowiring if there are more than one candidate
@Primary - set preferences for bean when more than one candidate found (injecting by default)
@Value - inject value from application.properties
@PropertySource - set properties file

@EnableAsync - enables support for async
annotation - what 'async' annotation types to be detected
mode - 'ASPECTJ'(AspectJ weaving-based advice) or 'PROXY' (Jdk proxy-based advice)
order - (int) order in which AsyncAnnotationPostProcessor should be applied
proxyTargetClass - (boolean) if true then use CGLIB proxy (class-based) instead of JDK dynamic proxy

@Async - starts method in a separate thread
- should be applied only for public methods
- self-invokation doesnt work
- can be used with void return type and with Future<> return type

@Resource - can inject bean by name in runtime
@Lazy -   ленивая инициализация бина - только когда он будет запрошен