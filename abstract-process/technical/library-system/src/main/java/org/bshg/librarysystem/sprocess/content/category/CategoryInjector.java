package org.bshg.librarysystem.sprocess.content.category;
import org.bshg.librarysystem.services.facade.content.CategoryService;
import org.bshg.librarysystem.sprocess.content.category.facade.CreateCategoryProcess;
import org.bshg.librarysystem.sprocess.content.category.facade.UpdateCategoryProcess;
import org.bshg.librarysystem.sprocess.content.category.facade.DeleteCategoryProcess;
import org.bshg.librarysystem.sprocess.content.category.impl.CreateCategoryProcessImpl;
import org.bshg.librarysystem.sprocess.content.category.impl.UpdateCategoryProcessImpl;
import org.bshg.librarysystem.sprocess.content.category.impl.DeleteCategoryProcessImpl;
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