package s06;
public class ShortToStringMapItr {

	private ShortToStringMap stsm;
	private int position = 0;
  // ----------------------------------------
 public ShortToStringMapItr (ShortToStringMap m) {
    this.stsm = m;
  }
 // ----------------------------------------
  public boolean hasMoreKeys() {
    return position<stsm.size();
  }
  // ----------------------------------------
  // PRE-condition: hasMoreKeys()
  public short   nextKey() {
	 // short result = (short) stsm.get(stsm.getPosOfKey((short) position));
    return 0; // TODO - A COMPLETER...
  }
}
