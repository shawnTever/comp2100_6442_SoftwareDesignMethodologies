public class BranchComplete {
	
	RBTree tree;
	
	public BranchComplete() {
		this.tree = new RBTree();

		this.tree.insert(9);
		this.tree.insert(7);
		this.tree.insert(5);
		this.tree.insert(8);
		this.tree.insert(11);
		this.tree.insert(10);
		this.tree.insert(12);
	}

	public int calcRBTree(int a, int b, int c) {

		int ret = 0;

		int sum = this.tree.sum(this.tree.root);
				
		if (sum > a) {
			if (sum < b) {
				ret = sum + b;
			}
			
			ret = sum + a;
		}

		if (b - a > c) {
			ret = sum + c;
		}

		return ret;
	}
}
