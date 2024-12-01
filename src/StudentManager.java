public class StudentManager {
    private Node root;

    public StudentManager() {
        root = null;
    }

    public void addStudent(Student student) {
        root = insert(root, student);
    }

    private Node insert(Node root, Student student) {
        if (root == null) {
            root = new Node(student);
            return root;
        }

        if (student.getMarks() < root.student.getMarks()) {
            root.left = insert(root.left, student);
        } else if (student.getMarks() > root.student.getMarks()) {
            root.right = insert(root.right, student);
        }
        return root;
    }

    public void deleteStudent(String studentID) {
        root = delete(root, studentID);
    }

    private Node delete(Node root, String studentID) {
        if (root == null) {
            System.out.println("Error: Student not found.");
            return root;
        }

        // If studentID is smaller, search in the left subtree
        if (studentID.compareTo(root.student.getId()) < 0) {
            root.left = delete(root.left, studentID);
        }
        // If studentID is larger, search in the right subtree
        else if (studentID.compareTo(root.student.getId()) > 0) {
            root.right = delete(root.right, studentID);
        }
        // When studentID is found
        else {
            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children, get the inorder successor (smallest in the right subtree)
            root.student = minValueNode(root.right).student;

            // Delete the inorder successor
            root.right = delete(root.right, root.student.getId());
        }

        return root;
    }

    private Node minValueNode(Node root) {
        Node current = root;
        // loop down to find the leftmost leaf
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Student searchStudent(String studentID) {
        return search(root, studentID);
    }

    private Student search(Node root, String studentID) {
        if (root == null || root.student.getId().equals(studentID)) {
            return root == null ? null : root.student;
        }

        if (studentID.compareTo(root.student.getId()) < 0) {
            return search(root.left, studentID);
        }
        return search(root.right, studentID);
    }

    public void displayAllStudents() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.student);
            inOrderTraversal(root.right);
        }
    }
}
