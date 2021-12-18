runCard:
	@clear
	@echo "Compiling..."
	@javac Card.java -Xlint
	@echo "Running"
	@clear
	@java Card

runDeck:
	@clear
	@echo "Compiling..."
	@javac Deck.java -Xlint
	@echo "Running"
	@clear
	@java Deck