/* Elimination of casts.
 * The following code snippet without generics requires casting:
 */
    List list = new ArrayList();
    list.add("hello");
    String s = (String) list.get(0);

/* When re-written to use generics, the code does not require casting:
 */
    List<String> list = new ArrayList<String>();
    list.add("hello");
    String s = list.get(0);   // no cast
