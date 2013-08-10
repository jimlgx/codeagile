/*
 * @project jimlgx-codeagile-generate
 * @package org.jimlgx.codeagile.generate.model
 * @file Folder.java
 * @version  1.0
 * @author  wangjunming
 * @time  2013-4-14
 */
package org.jimlgx.codeagile.generate.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.jimlgx.codeagile.generate.Generate;
import org.jimlgx.codeagile.generate.util.GenerateUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

/**
 * <code>Folder</code>
 * 
 * 文件夹 目录
 * 
 * @version 1.0
 * @author wangjunming
 * @since 1.0 2013-4-14
 */
public class Folder extends AbstractModel implements Generate {

	/**
	 * long serialVersionUID :
	 * 
	 * @since 2013-7-11 wangjunming
	 */
	private static final long serialVersionUID = -6733067602012379748L;

	/**
	 * String Basedir :当前目录 ${basedir}
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	private String basedir = StringUtils.EMPTY;

	/**
	 * Map<String,Folder> folders :子文件目录结构
	 * 
	 * @since 2013-8-1 wangjunming
	 */
	private Map<String, Folder> folders = new HashMap<String, Folder>();
	/**
	 * Map<String,FileModel> fileModels :文件对象
	 * 
	 * @since 2013-8-1 wangjunming
	 */
	private Map<String, FileModel> fileModels = new HashMap<String, FileModel>();

	/**
	 * 
	 */
	public Folder() {
	}

	/**
	 * @param code
	 */
	public Folder(String code) {
		super();
		this.setCode(code);

	}

	/**
	 * @return the Basedir
	 */
	public String getBasedir() {
		Assert.notNull(basedir, "please set dasedir");
		this.basedir = GenerateUtils.buildBasedir(basedir);
		return basedir;
	}

	/**
	 * @param Basedir
	 *            the Basedir to set
	 */
	public void setBasedir(String basedir) {
		Assert.notNull(basedir, "basedir not null");
		this.basedir = basedir;
	}

	/**
	 * <code>getPath</code>
	 * 
	 * 获得该目录路径 ${basedir}${code}
	 * 
	 * @return
	 * @since 2013-7-29 wangjunming
	 */
	public String getPath() {
		return getBasedir() + this.getCode();
	}

	/**
	 * @return the folders
	 */
	public Map<String, Folder> getFolders() {
		return folders;
	}

	/**
	 * @param folders
	 *            the folders to set
	 */
	public void setFolders(Map<String, Folder> folders) {
		this.folders = folders;
		if (!CollectionUtils.isEmpty(folders)) {
			for (Folder entry : this.folders.values()) {
				entry.setBasedir(getPath());
			}
		}
	}

	/**
	 * @return the fileModels
	 */
	public Map<String, FileModel> getFileModels() {
		return fileModels;
	}

	/**
	 * @param fileModels
	 *            the fileModels to set
	 */
	public void setFileModels(Map<String, FileModel> fileModels) {
		this.fileModels = fileModels;

		if (!CollectionUtils.isEmpty(this.fileModels)) {
			for (FileModel fileModel : this.fileModels.values()) {
				fileModel.setBasedir(getPath());
			}
		}

	}

	/**
	 * <code>generateFolder</code>
	 * 
	 * 生成目录
	 * 
	 * @since 2013-7-14 wangjunming
	 */
	protected void generateFolder() {

		GenerateUtils.createFileDirectory(new File(getPath()));

		if (!CollectionUtils.isEmpty(this.getFolders())) {
			Set<Entry<String, Folder>> set = getFolders().entrySet();
			for (Entry<String, Folder> entry : set) {
				entry.getValue().generate();
			}

		} else {
			logger.debug("empty folders code :{}", this.getCode());
		}
	}

	/**
	 * <code>generate</code>
	 * 
	 * @since 2013-4-11 wangjunming
	 */
	public void generate() {
		logger.debug("generate {} ", this.getPath());
		generateFolder();
		generateFileModels();
	}

	/**
	 * <code>generateFileModels</code>
	 * 
	 * @since 2013-7-30 wangjunming
	 */
	protected void generateFileModels() {
		if (!CollectionUtils.isEmpty(getFileModels())) {
			Collection<FileModel> values = getFileModels().values();
			for (FileModel fileModel : values) {
				fileModel.generate(this);
			}

		} else {
			logger.debug("empty fileModels code :{}", this.getCode());
		}
	}

	/**
	 * <code>docFolder</code>
	 * 
	 * 默认文档结构
	 * 
	 * @return
	 * @since 2013-7-29 wangjunming
	 */
	public static List<Folder> docFolders() {
		List<Folder> folders = new ArrayList<Folder>();
		folders.add(new Folder("doc"));
		folders.add(new Folder("doc\\db"));
		folders.add(new Folder("doc\\temp"));

		return folders;
	}

	/**
	 * <code>mapDocFolder</code>
	 * 
	 * @return
	 * @since 2013-8-1 wangjunming
	 */
	public static Map<String, Folder> mapDocFolder() {
		Map<String, Folder> map = new HashMap<String, Folder>();
		map.put("doc", new Folder("doc"));
		map.put("doc\\db", new Folder("doc\\db"));
		map.put("doc\\temp", new Folder("doc\\temp"));
		return map;
	}
}
