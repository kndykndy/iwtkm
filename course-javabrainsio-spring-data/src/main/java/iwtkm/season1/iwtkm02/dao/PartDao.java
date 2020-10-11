package iwtkm.season1.iwtkm02.dao;

import iwtkm.season1.iwtkm02.model.AbstractPart;
import java.util.List;

public interface PartDao<T extends AbstractPart> {

  void createNew(T part);

  T getById(int id);

  List<T> getAll();

  String getName(int id);

  int getCount();

}
