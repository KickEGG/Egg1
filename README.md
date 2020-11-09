# Egg1
EggFrame
Flexible Fast One


----------> DefaultBeanDefinitionDocumentReader#parseDefaultElement(Element ele, BeanDefinitionParserDelegate delegate) 解析xml结构中的root级别的标签:"import", "alias", "bean"的方法
-----------> processBeanDefinition(ele, delegate);根据输入的Bean元素，解析 BeanDefinition
**重要且核心的方法 processBeanDefinition 对Bean标签的解析**
>>>>>>>>>>>>> DefaultBeanDefinitionDocumentReader#processBeanDefinition(Element ele, BeanDefinitionParserDelegate delegate) 
>>>>>>>>>>>>>> BeanDefinitionHolder bdHolder = delegate.parseBeanDefinitionElement(ele);  BeanDefinitionHolder实例中已经包含了对配置文件root标签(class,name,id,alias)的解析结果
>>>>>>>>>>>>>>> BeanDefinitionParserDelegate#parseBeanDefinitionElement(Element ele, @Nullable BeanDefinition containingBean)方法,将根据xml中的beanId，beanName属性设置BeanDefinition的值，并会检查bean名字是否唯一；其返回的BeanDefinitionHolder已经包含了配置文件的各种属性（class,name,id,alias...)
>>>>>>>>>>>>>>>> AbstractBeanDefinition beanDefinition = parseBeanDefinitionElement(ele, beanName, containingBean);
>>>>>>>>>>>>>>>>> <kbd>BeanDefinitionParserDelegate</kbd>#parseBeanDefinitionElement(ele, beanName, containingBean);解析beanDefinition,无需Bean名或alias名
>>>>>>>>>>>>>>>>>> <kbd>BeanDefinitionParserDelegate</kbd>#parseBeanDefinitionElement AbstractBeanDefinition bd = createBeanDefinition(className, parent);
>>>>>>>>>>>>>>>>>>> BeanDefinitionParserDelegate#createBeanDefinition(className, parent); 通过bean的类名创建BeanDefinition
>>>>>>>>>>>>>>>>>>>> <kbd>BeanDefinitionParserDelegate</kbd> 
return BeanDefinitionReaderUtils.createBeanDefinition(parentName, className, this.readerContext.getBeanClassLoader());
>>>>>>>>>>>>>>>>>>>>> BeanDefinitionReaderUtils#createBeanDefinition(parentName, className, this.readerContext.getBeanClassLoader()) 注册(最终得到的实例),Bean名和Bean的配置(参考BeanDefinition),这里会创建一个GenericBeanDefinition，如果classloader不为空时，将获取这个类对象实例.
ps:测试例子走到这并没有被指定classLoader 
>>>>>>>>>>>>>>>>>> <kbd>AbstractBeanDefinition</kbd> #parseBeanDefinitionAttributes(ele, beanName, containingBean, bd);硬编码解析bd的一些属性：abstract,lazyInit,autowire,autowireCandidate,primary,init-method,destory-method,factory-method,factory-bean
>>>>>>>>>>>>>>>>>>> <kbd>AbstractBeanDefinition</kbd> parseMetaElements(ele, bd) 解析meta elements元数据;
					parseLookupOverrideSubElements(ele, bd.getMethodOverrides()) 解析lookup-method标签，其可以间接实现依赖注入
					parseReplacedMethodSubElements(ele, bd.getMethodOverrides()); 解析lookup-method标签，其可以实现改变方法的执行逻辑,用指定的方法替代目标方法
					parseConstructorArgElements(ele, bd);解析constructor-arg标签
					parseQualifierElements(ele, bd);解析qualifier标签					
>>>>>>>>>>>>>>> return new BeanDefinitionHolder(beanDefinition, beanName, aliasesArray); 利用BeanDefinitionHolder构造器创建方法

--------------> bdHolder = delegate.decorateBeanDefinitionIfRequired(ele, bdHolder); 寻找自定义标签并自定义标签,寻找命名空间处理器
--------------> BeanDefinitionReaderUtils.registerBeanDefinition(bdHolder, getReaderContext().getRegistry()); 注册BeanDefinition
---------------> DefaultListableBeanFactory#registerBeanDefinition(String beanName, BeanDefinition beanDefinition)；BeanDefinitionRegistry 的实现...注意synch锁的处理，这里Spring考虑到了同时调用的问题；这里如果Bean未被创建则放入beanDefinitionMap及beanDefinitionNames数组中,这就是BeanDefinition的注册！
--------------> getReaderContext().fireComponentRegistered(new BeanComponentDefinition(bdHolder));发送注册事件,将Bean加载完成信息通知监听器
