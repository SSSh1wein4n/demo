/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.personal.demo;

import java.util.Collection;

/**
 * {@link User} Service.
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 */
public interface UserService {

	/**
	 * 用户保存
	 *
	 * @param user 用户实体
	 * @return 是否成功
	 */
	boolean save(User user);

	/**
	 * 通过用户id删除用户
	 *
	 * @param userId 用户id
	 * @return 是否成功
	 */
	boolean remove(Long userId);

	/**
	 * 查询全部用户
	 *
	 * @return 用户实体集合
	 */
	Collection<User> findAll();

}
