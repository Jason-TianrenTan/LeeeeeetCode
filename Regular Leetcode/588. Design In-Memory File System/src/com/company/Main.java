package com.company;

import java.util.*;

public class Main {

    class FileSystem {

        class FileNode {
            boolean isFile;//true = file, false = directory
            String name;
            private TreeMap<String, FileNode> children;
            private StringBuilder content;

            public String getContent() {
                return content.toString();
            }

            public void append(String str) {
                this.content.append(str);
            }

            public FileNode(String name, boolean isFile) {
                this.name = name;
                this.isFile = isFile;
                if (!isFile)
                    children = new TreeMap<>(Comparator.naturalOrder());
                else content = new StringBuilder();
            }

            public boolean contains(String path) {
                return this.children.containsKey(path);
            }

            public void addChildren(FileNode node) {
                this.children.put(node.name, node);
            }

            public FileNode get(String path) {
                return this.children.get(path);
            }
        }

        FileNode root;

        public FileSystem() {
            root = new FileNode("/", false);
        }

        public List<String> ls(String path) {
            FileNode current = getNode(path);
            List<String> list = new ArrayList<>();
            if (current.isFile)
                list.add(current.name);
            else {
                for (Map.Entry<String, FileNode> entry : current.children.entrySet())
                    list.add(entry.getKey());
            }
            return list;
        }

        public void mkdir(String path) {
            String[] parts = path.split("/");
            FileNode current = root;
            for (int i = 1; i < parts.length; i++) {
                if (!current.contains(parts[i]))
                    current.addChildren(new FileNode(parts[i], false));
                current = current.children.get(parts[i]);
            }
        }

        public void addContentToFile(String filePath, String content) {
            String[] parts = filePath.split("/");
            FileNode current = root;
            String filename = parts[parts.length - 1];
            for (int i = 1; i < parts.length - 1; i++)
                current = current.get(parts[i]);
            if (!current.contains(filename))
                current.addChildren(new FileNode(filename, true));
            FileNode file = current.get(filename);
            file.append(content);
        }

        private FileNode getNode(String path) {
            String[] parts = path.split("/");
            FileNode current = root;
            for (int i = 1; i < parts.length; i++) {
                current = current.get(parts[i]);
            }
            return current;
        }

        public String readContentFromFile(String filePath) {
            FileNode file = getNode(filePath);
            return file.getContent();
        }
    }


    public void work() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/x.txt", "hello world");
        fileSystem.addContentToFile("/a/b/x.txt", ", mappa");
        System.out.println(fileSystem.readContentFromFile("/a/b/x.txt"));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
