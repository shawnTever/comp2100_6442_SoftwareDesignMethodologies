import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RBTreeTest {

	RBTree tree;

	@Before
	public void init() {
		this.tree = new RBTree();

		this.tree.insert(5);
		this.tree.insert(3);
		this.tree.insert(1);
		this.tree.insert(4);
		this.tree.insert(7);
		this.tree.insert(6);
		this.tree.insert(8);

		//paint the red black tree
		this.tree.search(1).setColour(true);
		this.tree.search(4).setColour(true);
		this.tree.search(6).setColour(true);
		this.tree.search(8).setColour(true);
	}

	@Test(timeout=1000)
	public void testNoBrokenNodes() {
		assertEquals(0, this.tree.countBrokenNodes());
	}
	
	@Test(timeout=1000)
	public void testRedRoot() {
		this.tree.search(5).setColour(true);

		assertEquals(1, this.tree.countBrokenNodes());
	}

	@Test(timeout=1000)
	public void testRedLeavesLeftRight() {
		this.tree.search(4).left.setColour(true);
		this.tree.search(6).right.setColour(true);

		assertEquals(4, this.tree.countBrokenNodes());
	}
	
	@Test(timeout=1000)
	public void testRedParent() {
		this.tree.search(7).setColour(true);

		assertEquals(1, this.tree.countBrokenNodes());
	}
	
	@Test(timeout=1000)
	public void testRedParentRedLeaves() {
		this.tree.search(6).left.setColour(true);
		this.tree.search(6).right.setColour(true);

		assertEquals(4, this.tree.countBrokenNodes());
	}
	
	@Test(timeout=1000)
	public void testRedRootRedParentRedLeaf() {
		this.tree.search(5).setColour(true);
		this.tree.search(7).setColour(true);
		this.tree.search(6).left.setColour(true);
		
		assertEquals(4, this.tree.countBrokenNodes());
	}
}
