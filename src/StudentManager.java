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
        if (root == null) return root;

        if (studentID.compareTo(root.student.getId()) < 0) {
            root.left = delete(root.left, studentID);
        } else if (studentID.compareTo(root.student.getId()) > 0) {
            root.right = delete(root.right, studentID);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.student = minValueNode(root.right).student;
            root.right = delete(root.right, root.student.getId());
        }
        return root;
    }

    private Node minValueNode(Node root) {
        Node current = root;
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
