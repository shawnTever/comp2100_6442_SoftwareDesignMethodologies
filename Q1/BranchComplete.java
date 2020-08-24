public class BranchComplete {
	
	BST tree;
	
	public BranchComplete() {
		this.tree = new BST();

		this.tree.insert(1, 'A');
		this.tree.insert(2, 'A');
		this.tree.insert(3, 'C');
		this.tree.insert(4, 'C');
		this.tree.insert(5, 'A');
		this.tree.insert(6, 'G');
		this.tree.insert(7, 'G');
	}

	public int DNATreeCalc(int a, int b, int c) {
		int ret = 0;

		int sum = this.tree.sum(this.tree.root);
				
		if (sum < a) {
			if (sum > b) {
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
