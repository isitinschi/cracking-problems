import java.util.List;
import java.util.ArrayList;
import java.lang.Iterable;
import java.util.Iterator;

public class PlayList implements Iterable<Song> {
	
	private List<Song> list;
	
	public PlayList() {
		list = new ArrayList<Song>();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void add(Song song) {
		list.add(song);
	}
		
	@Override
	public Iterator iterator() {
		return new SongIterator(list);
	}
	
	private class SongIterator implements Iterator<Song> {
		
		private List<Song> list;
		
		public SongIterator(List<Song> list) {
			this.list = list;
		}
		
		@Override
		public boolean hasNext() {
			return !list.isEmpty();
		}
		
		@Override
		public Song next() {
			if (list.isEmpty()) {
				throw new ArrayIndexOutOfBoundsException();
			}
			Song song = list.get(0);
			list.remove(0);
			return song;
		}
		
	}
	
}