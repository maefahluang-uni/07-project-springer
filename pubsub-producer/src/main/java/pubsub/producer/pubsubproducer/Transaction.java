package pubsub.producer.pubsubproducer;

class Transaction {
	// Enumerated type to represent transaction types.
	public enum TransactionType {
		Deposit, Withdraw
	};

	public TransactionType type;
	public int amount;

	/**
	 * Creates a Transaction object with a given type and amount.
	 */
	public Transaction(TransactionType type, int amount) {
		this.type = type;
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
