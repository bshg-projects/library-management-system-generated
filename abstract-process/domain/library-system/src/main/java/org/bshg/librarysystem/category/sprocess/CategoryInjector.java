package org.bshg.librarysystem.category.sprocess;
import org.bshg.librarysystem.category.services.CategoryService;
import org.bshg.librarysystem.category.sprocess.create.CreateCategoryProcess;
import org.bshg.librarysystem.category.sprocess.update.UpdateCategoryProcess;
import org.bshg.librarysystem.category.sprocess.delete.DeleteCategoryProcess;
import org.bshg.librarysystem.category.sprocess.create.CreateCategoryProcessImpl;
import org.bshg.librarysystem.category.sprocess.update.UpdateCategoryProcessImpl;
import org.bshg.librarysystem.category.sprocess.delete.DeleteCategoryProcessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* Inject Category Processes (Create, Update, Delete).
*/
@Configuration
public class CategoryInjector {
@Bean
public CreateCategoryProcess createCategoryProcess (CategoryService service) {
var bean = new CreateCategoryProcessImpl(service);
return bean;
}
@Bean
public UpdateCategoryProcess updateCategoryProcess (CategoryService service) {
var bean = new UpdateCategoryProcessImpl(service);
return bean;
}
@Bean
public DeleteCategoryProcess deleteCategoryProcess(CategoryService service) {
var bean = new DeleteCategoryProcessImpl(service);
return bean;
}
}