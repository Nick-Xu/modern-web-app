package com.github.edgarespina.mwa.view.mustache;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.Assert;
import org.springframework.web.servlet.view.AbstractTemplateView;

import com.github.mustachejava.Mustache;

/**
 * A mustache view implementation.
 *
 * @author edgar.espina
 * @since 0.1
 */
public class MustacheView extends AbstractTemplateView {

  /**
   * The compiled template.
   */
  private Mustache mustache;

  /**
   * Merge model into the view.
   * {@inheritDoc}
   */
  @Override
  protected void renderMergedTemplateModel(final Map<String, Object> model,
      final HttpServletRequest request, final HttpServletResponse response)
      throws Exception {
    mustache.execute(response.getWriter(), model);
  }

  /**
   * Set the compiled template.
   *
   * @param mustache The compiled template. Required.
   */
  public void setMustache(final Mustache mustache) {
    Assert.notNull(mustache, "A mustache template is required.");
    this.mustache = mustache;
  }
}