## Design Pattern Notes

Hello, world! 👋🏽

As the name suggests, this repo contains some notes I used to learn more about design patterns.
The content here is based in the famous *gang of 4* design patterns book: [**Design Patterns: 
Element of Reusable Object-Oriented Software**](https://www.amazon.com/Design-Patterns-Object-Oriented-Addison-Wesley-Professional-ebook/dp/B000SEIBB8), 
by Erich Gamma et al.

### Structure Of This Repo
This repo was built using Gradle and Kotlin. So you may want to get the latest version of
IntelliJ Idea CE or whatever text editor having Gradle support inr order to interact with it.

All the design patterns have a test suit, with examples of how the design pattern is used,
emulating a real-life scenario of how it could be used in production code. These tests
are intended to show the interaction between the involved classes in the design patterns,
and give a high-level overview of them.


### Design Patterns List
* Creational Patterns
  * [Abstract Factory](src/main/kotlin/dev/gonz/patterns/creational/AbstractFactory.kt) 
  * [Builder](src/main/kotlin/dev/gonz/patterns/creational/Builder.kt)
  * [Factory Method](src/main/kotlin/dev/gonz/patterns/creational/FactoryMethod.kt)
  * [Prototype](src/main/kotlin/dev/gonz/patterns/creational/Prototype.kt)
  * [Singleton](src/main/kotlin/dev/gonz/patterns/creational/Singleton.kt)

* Structural Patterns
  * [Adapter](src/main/kotlin/dev/gonz/patterns/structural/Adapter.kt)
  * [Bridge](src/main/kotlin/dev/gonz/patterns/structural/Bridge.kt)
  * [Composite](src/main/kotlin/dev/gonz/patterns/structural/Composite.kt)
  * [Decorator](src/main/kotlin/dev/gonz/patterns/structural/Decorator.kt)
  * [Facade](src/main/kotlin/dev/gonz/patterns/structural/Facade.kt)
  * [Flyweight](src/main/kotlin/dev/gonz/patterns/structural/Flyweight.kt)
  * [Proxy](src/main/kotlin/dev/gonz/patterns/structural/Proxy.kt)

* Behavioral Patterns
  * [Chain of Responsibility](src/main/kotlin/dev/gonz/patterns/behavioral/ChainOfResponsibility.kt)
  * [Command](src/main/kotlin/dev/gonz/patterns/behavioral/Command.kt)
  * Interpreter (pending)
  * [Iterator](src/main/java/dev/gonz/patterns/behavioral/iterable)
  * Mediator (pending)
  * [Memento](src/main/kotlin/dev/gonz/patterns/behavioral/Memento.kt)
  
New design patterns will be included as time passes.
    
### Contributing

Any contribution is welcome! Just keep in mind that, since this is a little project with study
purposes, no CI is configured (yet), so be sure you ran all the tests and all of them passes,
so we can all have an self-contained version of the project. To do so:
1. Fork the repo
2. Clone your fork
3. Create a new branch
4. Code (the exciting part)
5. Push (to your form)
6. Open a PR to the upstream repo
7. Wait for review

Cheers! 🍻